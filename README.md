# Sunrise and Sunset(Spring boot rest API OpenWeather)
Repository creata per prova d'esame gennaio 2021 per il corso di programmazione ad oggetti.

## Applicazione
L'applicazione utilizza l'API Current Weather Data di OpenWeather per accedere ai dati di alba e tramonto di una certa città.
I dati vengono poi salvati per creare uno storico. Su di esso vengono fatte delle analisi riguardati la variazione di orario di alba e tramonto della città scelta dall'utente.


## Rotte applicazione

* **Keys:**
	* paese = città scelta dall'utente
	
* Per le chiamate di tipo **Post** i parametri vengono passati attraverso un **Request Body**.
I parametri che dovranno essere passati sono:

	* "start": (scrivere la data di inizio nel formato dd-MM-yyyy)

	* "end": (scrivere la data di fine nel formato dd-MM-yyyy)

	* "name": (scrivere il nome della città della quale si vogliono conoscere i dati)

	* "type": (scrivere "min" o "max")

1.
Tipo | Path |
---- | ---- |
Get | localhost:8080/Weather/{paese} |

Fornisce all'utente orario di alba e tramonto della giornata odierna della città cercata.

Sostituire **paese** con la città da cercare.

**Esempio** 

chiamata:

![Schermata 2021-01-20 alle 12 50 47 PM](https://user-images.githubusercontent.com/71764245/105171194-3d44d600-5b1e-11eb-9f46-59f2e2db4017.png)

risposta:

![Schermata 2021-01-20 alle 12 50 38 PM](https://user-images.githubusercontent.com/71764245/105171264-4f267900-5b1e-11eb-9693-479b2aaef531.png)

2.
Tipo | Path |
---- | ---- |
Get | localhost:8080/CityMonitor |

Fornisce all'utente l'elenco delle città monitorate fino ad oggi.

**Esempio**

chiamata:

![Schermata 2021-01-14 alle 17 26 15 PM](https://user-images.githubusercontent.com/71764245/104618960-a1cee380-568d-11eb-8a95-215d5a8ecb6a.png)

risposta:

![Schermata 2021-01-14 alle 17 27 46 PM](https://user-images.githubusercontent.com/71764245/104619166-d93d9000-568d-11eb-9b3e-cfe9c4d2b3f9.png)

3.
Tipo | Path |
---- | ---- |
Post | localhost:8080/History |

Fornisce all'utente lo storico dei dati relativi alla città cercata ordinati in modo crescente per data.

I parametri da inserire nel **Body** sono: "start", "end", "name".

Se start e end non vengono dichiarati verranno presi come dati di default per start il primo e per end l'ultimo giorno disponibile in archivio.

**Esempio**

chiamata:

![Schermata 2021-01-14 alle 17 41 32 PM](https://user-images.githubusercontent.com/71764245/104620877-c3c96580-568f-11eb-8144-5f2f24cdc745.png)

body:

![Schermata 2021-01-14 alle 17 40 40 PM](https://user-images.githubusercontent.com/71764245/104620764-a4cad380-568f-11eb-846a-62b305cdf6fd.png)

risposta:

![Schermata 2021-01-14 alle 17 42 15 PM](https://user-images.githubusercontent.com/71764245/104620958-de034380-568f-11eb-8477-e3231b567d58.png)
	
4.
Tipo | Path |
---- | ---- |
Post | localhost:8080/Stats |

Fornisce all'utente le statistiche di alba e tramonto di una certa città in base al periodo selezionato. Le statistiche consistono nel visualizzare a schermo la differenza(in positivo e/o in negativo) di orario di alba e tramonto di un certo giorno rispetto ad un'altro.

I parametri da inserire nel **Body** sono: "start", "end", "name". 

Se start e end non vengono dichiarati verranno presi come dati di default per start il primo e per end l'ultimo giorno disponibile in archivio.

**Esempio**

chiamata:

![Schermata 2021-01-14 alle 17 49 50 PM](https://user-images.githubusercontent.com/71764245/104621914-eb6cfd80-5690-11eb-800d-9bbfdef0be7a.png)

body:

![Schermata 2021-01-14 alle 17 50 36 PM](https://user-images.githubusercontent.com/71764245/104622009-06d80880-5691-11eb-88d3-9a6783403c23.png)

risposta:

![Schermata 2021-01-14 alle 17 50 58 PM](https://user-images.githubusercontent.com/71764245/104622055-16575180-5691-11eb-8626-5b67d84a7f3c.png)

5.
Tipo | Path |
---- | ---- |
Post | localhost:8080/Variances |

Fornisce all'utente informazione riguardante la variazione massima o minima(in base a quella richiesta dall'utente) di alba e tramonto dellla città cercata rispetto a certo periodo.

I parametri da inserire nel **Body** sono: "start", "end", "name", "type".

Se start e end non vengono dichiarati verranno mostrate le variazioni di alba e tramonto calcolate su tutto il periodo presente nello storico. Start e end prendono come default rispettivamente la prima e l'ultima data disponibili in archivio.

**Esempio**

richiesta:

![Schermata 2021-01-14 alle 17 52 55 PM](https://user-images.githubusercontent.com/71764245/104622286-59b1c000-5691-11eb-94fa-9946fcce756f.png)

body:

![Schermata 2021-01-14 alle 17 53 35 PM](https://user-images.githubusercontent.com/71764245/104622368-70f0ad80-5691-11eb-85ff-9e68a8f00a47.png)

risposta:

![Schermata 2021-01-14 alle 17 54 01 PM](https://user-images.githubusercontent.com/71764245/104622409-8239ba00-5691-11eb-9e55-c03317c98ed9.png)
	
## UML
* Casi d'uso:
![Untitled Document](https://user-images.githubusercontent.com/71764245/102500681-dd6d9200-407c-11eb-9096-57e0271d8aaa.png)

* Classi:

![Schermata 2021-01-03 alle 15 54 20 PM](https://user-images.githubusercontent.com/71764245/103481573-30b14580-4ddc-11eb-87eb-38940a39a11a.png)

![Schermata 2021-01-03 alle 15 54 35 PM](https://user-images.githubusercontent.com/71764245/103481574-327b0900-4ddc-11eb-9176-d187faf12480.png)

![Schermata 2021-01-03 alle 15 54 48 PM](https://user-images.githubusercontent.com/71764245/103481575-34dd6300-4ddc-11eb-991c-608fe2530cf5.png)

![Schermata 2021-01-03 alle 15 55 02 PM](https://user-images.githubusercontent.com/71764245/103481577-360e9000-4ddc-11eb-863b-78dcb91e438f.png)

![Schermata 2021-01-03 alle 15 55 15 PM](https://user-images.githubusercontent.com/71764245/103481580-37d85380-4ddc-11eb-91fe-0fa04943c33f.png)

![Schermata 2021-01-03 alle 15 55 30 PM](https://user-images.githubusercontent.com/71764245/103481584-3b6bda80-4ddc-11eb-961b-1cc695c6dc0b.png)



* Sequenze:

![Schermata 2021-01-02 alle 22 37 28 PM](https://user-images.githubusercontent.com/71764245/103481491-a5d04b00-4ddb-11eb-8152-0717b34a1f68.png)

![Schermata 2021-01-03 alle 15 25 51 PM](https://user-images.githubusercontent.com/71764245/103481492-a8cb3b80-4ddb-11eb-83e6-5ada68cc25de.png)

![Schermata 2021-01-03 alle 15 35 44 PM](https://user-images.githubusercontent.com/71764245/103481495-ab2d9580-4ddb-11eb-8e64-706a119acaad.png)

![Schermata 2021-01-03 alle 15 42 46 PM](https://user-images.githubusercontent.com/71764245/103481497-acf75900-4ddb-11eb-8895-1bd595072662.png)

![Schermata 2021-01-03 alle 15 49 25 PM](https://user-images.githubusercontent.com/71764245/103481499-ae288600-4ddb-11eb-84b7-839d35fee117.png)

## Possibile implementazione del progetto:
Un possibile caso di implementazione della nostra applicazione potrebbe essere l'utilizzo urbano che prevede l'accensione e lo spegnimento dell'illuminazione pubblica in base a orario di alba e tramonto. Così da rendere automatico e più efficiente l'illuminazione pubblica ed evitando sprechi di corrente.

## Autore
Nome| email |
De Ritis Riccardo | S1094657@studenti.univpm.it |



