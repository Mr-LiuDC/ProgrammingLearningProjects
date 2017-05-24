@echo off

: set REPO_PATH=%USERPROFILE%\.m2\repository
set REPO_PATH=G:\.m2\repository

:: 冒号为注释符号

:: echo 正在清理%REPO_PATH%目录下的.lastUpdated后缀文件

echo Clearing the .lastUpdated suffix file in the %REPO_PATH% directory

del /s %REPO_PATH%\*.lastUpdated

:: echo 清理完成

echo done

pause