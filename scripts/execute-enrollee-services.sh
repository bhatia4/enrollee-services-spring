#!/bin/bash
cd .. && nohup java -jar target/enrollee-services-0.0.1-SNAPSHOT.jar >logs/stdout.txt 2>&1 &