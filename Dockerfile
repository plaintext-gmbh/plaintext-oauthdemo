FROM openjdk:21-jdk-slim

COPY "target/*oauth*.jar" "app.jar"

ENTRYPOINT ["java",\
"--add-opens=java.base/java.util=ALL-UNNAMED", \
"--add-opens=java.base/java.text=ALL-UNNAMED", \
"--add-opens=java.desktop/java.awt.font=ALL-UNNAMED", \
"--add-opens=java.base/java.lang=ALL-UNNAMED", \
"--add-opens=java.base/java.lang.ref=ALL-UNNAMED", \
"--add-opens=java.base/java.lang.reflect=ALL-UNNAMED",\
"-jar","/app.jar"]