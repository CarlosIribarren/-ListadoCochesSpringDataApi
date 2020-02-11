
############################################################
## Etapa : Package #########################################
############################################################

FROM maven:3.6.3-jdk-8-slim AS ETAPA_MAVEN
WORKDIR /build/
COPY /pom.xml /build/
COPY /src /build/src/
RUN mvn -Dmaven.test.skip=true package

############################################################
## Etapa : Ejecutar ########################################
############################################################


FROM gcr.io/distroless/java:8
WORKDIR /app
COPY --from=ETAPA_MAVEN /build/target/ListadoCochesSpringDataApi-exec.jar /app/
ENTRYPOINT ["java", "-jar", "ListadoCochesSpringDataApi-exec.jar"]


# NOTA: Este proyecto tiene dependecia de la BD. Necesita que la BD este levantada.


# Crear imagen
# ------------
#  docker image build --no-cache -t listado-coches-api .

# Crear container
# ---------------
#  docker run -p 8081:8081 listado-coches-api

# Probar
# ------
# http://localhost:8081/api/coche/findByFechaMatriculacionBetween?fechaInicio=2000-01-01&fechaFin=2020-01-01&page=0&size=25