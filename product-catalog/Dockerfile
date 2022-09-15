FROM adoptopenjdk/openjdk11:latest
COPY target/product-catalog-0.0.1-SNAPSHOT.jar product-catalog.jar
ENV JAVA_OPTS="-Djasypt.encryptor.algorithm=PBEWithMD5AndDES  -Djasypt.encryptor.password=ecommerce -Djasypt.encryptor.iv-generator-classname=org.jasypt.iv.NoIvGenerator"
EXPOSE 8081
ENTRYPOINT exec java $JAVA_OPTS  -jar /product-catalog.jar