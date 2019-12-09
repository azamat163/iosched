Тесты располагаются в package mobile, для запуска тестов необходимо build Variants для mobile задать staging.
Ниже расположена архитектура тестов:
mobile-|
       |_src
          |
          |_androidTest
                 |
                 |_java
                     |
                     |_com/google/samples/apps/iosched/tests
                                      |
                                      |_core
                                      |
                                      |_pages
                                      |
                                      |_tests

Запуск тестов осуществляется по следующей команде:
adb shell am instrument -w -r   -e package com.google.samples.apps.iosched.tests.tests -e debug false com.google.samples.apps.iosched.test/io.qameta.allure.espresso.AllureAndroidRunner

Для генерации репорта:
adb pull /sdcard/allure-results
allure generate
