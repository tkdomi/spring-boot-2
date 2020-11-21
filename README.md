# Kurs Spring Boot 2


## Tydzień 2
Zaimplementuj sklep internetowy, który oferuje 3 warianty.
Podstawową funkcjonalnością jaką posiada każdy sklep jest wariant „START”. Umożliwia on na dodawanie produktów do koszyka (produkt przechowuje nazwę i cenę), oraz na ich podstawie wypisywać na oknie konsoli cenę wszystkich produktów.
Pakiet „PLUS” dodatkowo umożliwia doliczenie do ceny wynikowej podatku VAT. Stawka podatku VAT ma zostać uwzględniona w pliku konfiguracyjnym.
Pakiet „PRO” oprócz wyliczania podatku ma również możliwość wyliczenia rabatu, którego wartość jest uwzględniona w pliku konfiguracyjnym.
Aplikacja na start dodaje 5 dowolnych produktów z losowaną ceną (w przedziale 50-300 zł) i wyświetla ich sumaryczną cenę.

## Tydzień 3
Zadanie podstawowe:
Napisz REST API dla listy pojazdów. Pojazd będzie miał pola: id, mark, model, color.
API które będzie obsługiwało metody webowe:

* do pobierania wszystkich pozycji
* do pobierania elementu po jego id
* do pobierania elementów w określonym kolorze (query)
* do dodawania pozycji
* do modyfikowania pozycji
* do modyfikowania jednego z pól pozycji
* do usuwania jeden pozycji

Przy starcie aplikacji mają dodawać się 3 pozycje.

—————————

Dla ambitnych:

* rozbuduj aplikacje o możliwość zwracania danych w postaci XML
* dodaj obsługę Swgger UI
* zaimplementuj HATEOAS

## Tydzień 5
Zadanie 1 – na rozgrzewkę
Wybierz usługę, która zwraca kolekcje. Możesz użyć, któregoś z tych serwisów: https://github.com/public-apis/public-apis
Następnie skomunikuj się z usługą poprzez wykorzystanie klasy RestTemplate.
Z wykorzystaniem swojego ulubionego narzędzia do tworzenia GUI wyświetl wszystkie dane we formie tabelarycznej.

Zadanie 2 – pogodynka
Połącz się z serwisem pogodowym i stwórz widok, który umożliwia na wprowadzanie miasta do pola tekstowego miasta. Po zatwierdzeniu przyciskiem wyświetli się aktualna pogoda dla danej miejscowości wraz z odzwierciedlającą pogodę grafiką.

Zadanie 3 – gra walutowa
Pobierz aktualny kursy walut. W momencie, kiedy gracz wejdzie do gry wyświetla mu się losowo wybrana waluta, której kurs względem złotówki musi odgadnąć.
Np. Aplikacja: Wprowadź aktualną kurs USD uwzględniając 2 miejsca po przecinku
Użytkownik: 4,20
Aplikacja: Za dużo
Użytkownik: 3,90
Aplikacja: Za mało
Użytkownik: 3,93
Aplikacja: Gratki! Udało się za 3 razem!
Może być to aplikacja konsolowa lub okienkowa
