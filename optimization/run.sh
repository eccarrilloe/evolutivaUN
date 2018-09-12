if [[ $1 = "compile" ]]; then
  rm -rf out/ && mkdir out
  javac -cp out/ -d out/ src/unal/functions/*.java src/unal/optimization/*.java
  javac -cp out/ -d out/ test/*.java
elif [[ $1 = "test" ]]; then
  java -cp out "test.$2"
elif [[ $1 = "clean" ]]; then
  rm -rf out/
else
  echo "Error: Option invalid"
fi
