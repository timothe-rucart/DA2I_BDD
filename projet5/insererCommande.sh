#!/bin/bash

for ((j=0;j<=1000;j++))
do
	echo $[($RANDOM % ($[1000 - 1] + 1))] ";" $i ";" $[($RANDOM % ($[100 - 1] + 1))] >> insererCommandes.csv
done
