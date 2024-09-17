# Java Streams

## Wann nutze ich was ?

Basically ziemlich einfach. Meistens macht es Sinn sich die Problematik erstmal als for-each Schleife anzuschauen. 
Es kann durchaus sein, dass sich das Problem mit nem Stream nur umständlicher lösen lässt.

Wenn wir also folgendes Problem haben:

Gehe durch die Liste und lösche alle Personen unter 18 raus.
Dann veränder den Namen sodass es er nur UPPERCASE ist.
Das Alter ist an diesem Punkt egal und muss nicht mit zurück gegeben werden.


Als for-each könnte das in Pseudocode so aussehen:
```java

var resultList = []
for(var person : Persons){
    if(person.age < 18) continue;

    var upperCaseName = person.name.uppercase

    resultList.add(upperCaseName)
}

```

Wir haben hier also 2 verschiedene Doings:
1. Filtern der unter 18 Jährigen
2. Umändern des Namens in Uppercase

Daraus können wir schlie0en, wir brauchen mindestens ein .filter() und ein .map()