FROM azul/zulu-openjdk:11

RUN apt-get update && \
    apt-get install -y --no-install-recommends software-properties-common curl && \
    apt-add-repository multiverse && \
    apt-get update && \
    apt-get install -y wget && \
    wget http://ftp.de.debian.org/debian/pool/contrib/m/msttcorefonts/ttf-mscorefonts-installer_3.6_all.deb && \
    echo "ttf-mscorefonts-installer msttcorefonts/accepted-mscorefonts-eula select true" | debconf-set-selections && \
    apt install -y ./ttf-mscorefonts-installer_3.6_all.deb

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} solucredit.jar
ENTRYPOINT ["java","-jar","/solucredit.jar"]