#!/bin/bash

mkdir -p src/test/resources/results/actual/junit/

EXPECTED_RESULT="src/test/resources/results/expected/junit/junit-expected.xml"
ACTUAL_RESULT="junit.xml"

mvn clean verify \
    -Dmode=verify \
    -DjmeterCsv=src/test/resources/csv/jmeter/2_transactions.csv \
    -DtestSetXml=src/test/resources/xml/junit_report.xml \
    -DperfmonCsv=src/test/resources/csv/perfmon/junit_report.csv \
    > /dev/null # LOL http://www.mongodb-is-web-scale.com

DIFF_OUTPUT=`diff $EXPECTED_RESULT $ACTUAL_RESULT`
OUT=$?

echo -e ''; echo `basename "$0"`

if [ $OUT -eq 0 ];then
    echo "OUTPUT AS EXPECTED"
    echo "TEST PASSED"
    exit 0
else
    echo "INCORRECT CONSOLE OUTPUT - DIFF:"
    echo $DIFF_OUTPUT
    echo "TEST FAILED"
    exit 1
fi