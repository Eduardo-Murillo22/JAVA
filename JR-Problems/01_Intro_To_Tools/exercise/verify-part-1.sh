#!/bin/bash
# This exercise validates that the students completed the steps as
# specified in the README correctly.

ERRORS=0
PASSED_COUNT=0
BASE=~/playground
outputFile=output-part-1.txt

clear
echo ""                                 > $outputFile
echo "---- VERIFYING PART 1 ---- "      >> $outputFile
echo ""                                 >> $outputFile

DIRS=("" "/usa" "/canada" "/usa/ohio" "/usa/pennsylvania" "/usa/michigan" "/canada/quebec" "/canada/british-columbia" "/usa/ohio/cuyahoga"
"/usa/ohio/hamilton" "/usa/ohio/franklin" "/usa/pennsylvania/allegheny" "/usa/michigan/wayne")
gz
FILES=("/usa/ohio/cuyahoga/cleveland.txt" "/usa/ohio/hamilton/cincinnati.txt"
"/usa/ohio/franklin/columbus.txt" "/usa/pennsylvania/allegheny/pittsburgh.txt" "/usa/michigan/wayne/detroit.txt" "/canada/quebec/montreal.txt" "/canada/quebec/quebec-city.txt"
"/canada/british-columbia/vancouver.txt" "/canada/british-columbia/prince-george.txt")

EXERCISE_COUNT=$((${#DIRS[@]}+${#FILES[@]}))
STEP=0

# Look for each directory
for i in "${!DIRS[@]}"
do
    STEP=$((STEP+1))
    PATH_TO_CHECK="$BASE${DIRS[$i]}"

    if test -d "$PATH_TO_CHECK"; then
        echo "✅ $STEP. $PATH_TO_CHECK exists"        >> $outputFile
        PASSED_COUNT=$((PASSED_COUNT+1))
    else
        echo "❗️ $STEP. $PATH_TO_CHECK does not exist" >> $outputFile
        ERRORS=$((ERRORS+1))
    fi
done

# Look for each file
for i in "${!FILES[@]}"
do
    STEP=$((STEP+1))
    PATH_TO_CHECK="$BASE${FILES[$i]}"

    if test -f "$PATH_TO_CHECK"; then
        echo "✅ $STEP. $PATH_TO_CHECK exists"        >> $outputFile
        PASSED_COUNT=$((PASSED_COUNT+1))
    else
        echo "❗️ $STEP. $PATH_TO_CHECK does not exist" >> $outputFile
        ERRORS=$((ERRORS+1))
    fi
done

echo ""                                             >> $outputFile
echo "Total tests: $EXERCISE_COUNT"                 >> $outputFile
echo "Tests passed: $PASSED_COUNT"                  >> $outputFile
echo "Errors: $ERRORS"                              >> $outputFile
echo ""                                             >> $outputFile

if ((ERRORS==0)); then
    echo "Congratulations! All tests in Part 1 are passing."    >> $outputFile
    echo "Continue on to Part 2 in the README."                 >> $outputFile
    echo ""                                                     >> $outputFile
fi

if ((ERRORS>0)); then
    echo " You still need to make a few more changes."                                                      >> $outputFile
    echo " If you are having difficulty troubleshooting, try the following:"                                >> $outputFile
    echo " - Use 'pwd' to print out your current working directory."                                        >> $outputFile
    echo " - Check for typos in the names of folders or file paths."                                        >> $outputFile
    echo " - Verify you created the right type—a folder or a file."                                          >> $outputFile
    echo " - When changing directories, '..' means up one directory. '.' means the current directory."      >> $outputFile
    echo " - Reference the paths in File Explorer to make sure everything is in the correct location."      >> $outputFile
    echo ""                                                                                                 >> $outputFile
fi

cat $outputFile
