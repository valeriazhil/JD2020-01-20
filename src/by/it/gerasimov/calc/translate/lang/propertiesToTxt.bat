FOR %%I In (*.properties) DO (
native2ascii -reverse -encoding utf-8 %%I ..\text\%%~nI.txt
)