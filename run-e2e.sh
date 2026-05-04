#!/bin/bash
# Запуск e2e-тестов. Использование:
#   ./run-e2e.sh              — все e2e тесты
#   ./run-e2e.sh AccountPageTest
#   ./run-e2e.sh FirstScreenTest
#   ./run-e2e.sh FirstScreenTest#testFirstScreen

cd "$(dirname "$0")"
if [ -n "$1" ]; then
  mvn test -Pe2e -Dtest="$1"
else
  mvn test -Pe2e
fi
