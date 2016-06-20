#!/bin/bash
set -e

function gen_config() {
    PATH_CONFIG=/server

    DB_HOST=${DB_HOST:-mariadb}
    DB_PORT=${DB_PORT:-3306}
    DB_USERNAME=${DB_USERNAME:-root}
    DB_PASSWORD=${DB_PASSWORD:-lab@secret}
    DB_DATABASE=${DB_DATABASE:-opencps10}

    # generate file config
    cp ${PATH_CONFIG}/portal-ide.properties.default ${PATH_CONFIG}/portal-ide.properties

    cp ${PATH_CONFIG}/portal-setup-wizard.properties.default ${PATH_CONFIG}/portal-setup-wizard.properties

    sed -i s/DB_HOST/${DB_HOST}/ ${PATH_CONFIG}/portal-setup-wizard.properties
    sed -i s/DB_PORT/${DB_PORT}/ ${PATH_CONFIG}/portal-setup-wizard.properties
    sed -i s/DB_USERNAME/${DB_USERNAME}/ ${PATH_CONFIG}/portal-setup-wizard.properties
    sed -i s/DB_PASSWORD/${DB_PASSWORD}/ ${PATH_CONFIG}/portal-setup-wizard.properties
    sed -i s/DB_DATABASE/${DB_DATABASE}/ ${PATH_CONFIG}/portal-setup-wizard.properties
}

# prepare for config default
gen_config

if [ "$1" = 'start-tomcat' ]; then

    ##################### handle SIGTERM #####################
    function _term() {
        printf "%s\n" "Caught terminate signal!"
        /server/tomcat-7.0.62/bin/catalina.sh stop

        # kill -SIGTERM $child 2>/dev/null
        exit 0
    }

    trap _term SIGHUP SIGINT SIGTERM SIGQUIT

    ##################### start application #####################
    # start tomcat
    /server/tomcat-7.0.62/bin/catalina.sh run

    # # make sure log file existed
    # touch ${PATH_OFBIZ}/runtime/logs/ofbiz.log

    # tail -f ${PATH_OFBIZ}/runtime/logs/ofbiz.log &
    # child=$!
    # wait "$child"
fi

exec "$@"
