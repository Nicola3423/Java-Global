FROM ubuntu:latest
LABEL authors="Nicola"

ENTRYPOINT ["top", "-b"]