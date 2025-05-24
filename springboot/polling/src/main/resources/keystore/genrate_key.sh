#!/bin/bash
# Author: Nguyen Khac Trung Kien

keytool -genkeypair \
  -alias polling \
  -keyalg RSA \
  -keysize 2048 \
  -storetype PKCS12  \
  -keystore app-key.p12 \
  -validity 3650 \
  -storepass secret-spring-app
