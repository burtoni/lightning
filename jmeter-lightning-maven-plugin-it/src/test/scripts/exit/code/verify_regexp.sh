#!/bin/bash

mkdir -p src/test/resources/results/actual/

mvn clean verify \
    -Dmode=verify \
    -DjmeterCsv=src/test/resources/csv/jmeter/10_transactions.csv \
    -DtestSetXml=src/test/resources/xml/regexp.xml \
    > src/test/resources/results/actual/regexp.txt
OUT=$?

echo -e ''; echo `basename "$0"`

if [ $OUT = 0 ];then
    echo "EXIT CODE = $OUT"
    echo "TEST PASSED"
    exit 0
else
    echo "EXIT CODE = $OUT"
    echo "TEST FAILED"
    exit 1
fi