FROM postgres:10.4-alpine

ARG DB_MAX_CONNECTIONS="100"
ARG DB_TIMEZONE="UTC"

COPY postgresql.conf /etc/postgresql/postgresql.conf
RUN cat /etc/postgresql/postgresql.conf | \
    sed "s/max_connections = 100/max_connections = $DB_MAX_CONNECTIONS/g" | \
    sed "s~timezone = 'UTC'~timezone = '${DB_TIMEZONE}'~g" | \
    sed "s~log_timezone = 'UTC'~log_timezone = '${DB_TIMEZONE}'~g" > /etc/postgresql/postgresql.configured && \
    mv /etc/postgresql/postgresql.configured /etc/postgresql/postgresql.conf
