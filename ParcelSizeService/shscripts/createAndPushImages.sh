#!/bin/bash

echo "Test-VM mit vorintsalliertem Docker über vagrantfile starten"

vagrant up

echo "Test-VM gestartet"

echo "Speichere Images und lade... Abgeschlossen."

for var in "$@"
do
   	#local image speichern, damit sind diese automatisch im shared folder
	docker save -o $var $var
	
	#image auf asset server übertragen
	# sftp vagrant@192.168.50.100:/vagrant/html/images <<< $'put '$var
	
	# images remote über shared folder laden
	vagrant ssh -c 'docker load -i /vagrant/'$var
	
	# temporär lokales image löschen
	rm $var

done

echo "Speichere Images und lade... Abgeschlossen."

