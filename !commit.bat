@echo off
set /p commitMsg= Enter commit message: 
git add .
git commit -m "%commitMsg%"
pause
git push origin master
pause