from registry.access.redhat.com/ubi9/ubi
WORKDIR /tmp
ENV KEYCLOAK_VERSION=23.0.4
ENV KC_EXTENTION=zip
ARG KEYCLOAK_DIST=https://github.com/keycloak/keycloak/releases/download/$KEYCLOAK_VERSION/keycloak-$KEYCLOAK_VERSION.zip
RUN curl -LO $KEYCLOAK_DIST
USER root
RUN dnf install -y unzip
RUN dnf install -y java-17-openjdk java-17-openjdk-devel
#ADD $KEYCLOAK_DIST /tmp/
RUN unzip keycloak-$KEYCLOAK_VERSION.$KC_EXTENTION
RUN rm keycloak-$KEYCLOAK_VERSION.$KC_EXTENTION
RUN cd keycloak-$KEYCLOAK_VERSION/ && mkdir -p /opt/keycloak && mv * /opt/keycloak && mkdir -p /opt/keycloak/data
RUN chmod -R g+rwX /opt/keycloak
RUN chown -R 1001:1001 /opt/keycloak
USER 1001
RUN cd /opt/keycloak/bin && echo $(ls -ltr)
ENTRYPOINT ["/opt/keycloak/bin/kc.sh"]
#RUN cd /tmp && echo $(ls -ltr)
#USER root
#RUN mv /tmp/keycloak/keycloak-* /opt/keycloak && mkdir -p /opt/keycloak/data

##RUN INSTALL_PKGS ="postgresql" && \
    #dnf install -y $INSTALL_PKGS --skip-broken --nobest && \
    #rpm -V $INSTALL_PKGS
##RUN chmod -R g+rwX /opt/keycloak
#USER 1000
#ENV KC_DB=postgres
#ENV KC_DB_USERNAME=keycloak
#ENV KC_DB_PASSWORD=keycloak
#ENV KC_HOSTNAME=localhost
#ENTRYPOINT ["/opt/keycloak/bin/kc.sh start-dev"]
