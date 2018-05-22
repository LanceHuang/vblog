FROM tomcat:7-alpine
MAINTAINER "Lance <tellme@yeah.net>"

COPY target/*.war webapps
