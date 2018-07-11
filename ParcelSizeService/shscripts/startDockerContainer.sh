#!/bin/bash

# Docker network erstellen in dem alle container laufen 
vagrant ssh -c 'docker network create parcelconfig-net'

# alle container starten
vagrant ssh -c 'docker run -p 9090:9090 -d --net parcelconfig-net --name=parcelservice dev_parcelservice'

vagrant ssh -c 'docker run -p 8888:8080 -d --net parcelconfig-net --name=webpageparcelsize dev_webpageparcelsize'

vagrant ssh -c 'docker run -p 3306:3306 -e  MYSQL_ROOT_PASSWORD=root -d --net parcelconfig-net --name=parceldb mysql:5.7'

#datenbank braucht etwas zeit um zu starten... 
sleep 5s

# mysql dump zurückspielen auf gestartete datenbank
cat db/backup.sql | vagrant ssh -c 'docker exec -i parceldb /usr/bin/mysql -u root --password=root' 
