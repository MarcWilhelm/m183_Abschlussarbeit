Hallo Herzlich Wilkommen



# 4 WebGoat (A07) Identification and Authentication Failures 

## 4.1 Beschreibung 

Bei Identification und Authentication Failures geht es darum, dass die Identität eines Benutzers bei der Identifizierung und der Authentifizierung nicht genau beziehungsweise nicht korrekt überprüft wird oder es wird nicht sichergestellt, dass die richtige Person Zugriff auf eine bestimmte Ressource hat.

## 4.2 Authentication Bypasses 

Die Authentifizierung kann auf verschiedene Wege umgangen werden, oft kommt es aber vor, dass es Fehler in der Konfiguration oder in der Logik gibt. Dadurch kann ein System manipuliert und die Authentifizierung umgangen werden. Auch wenn in dieser Aufgabe nur ein fiktives Szenario simuliert wird, hat es mich erstaunt, dass es bei Paypal so eine Sicherheitslücke gab. Mit Hilfe der Hinweise konnte ich die Aufgabe recht einfach lösen. Bei einem Hinweis wurde man darauf aufmerksam gemacht, dass man die Parameter umbenennen sollte. Ich habe in Burp den Request abgefangen und dann die Parameter einfach umbenannt. Dann habe ich den Request weitergesendet. Ergebnis:
![image](https://github.com/MarcWilhelm/m183_Abschlussarbeit/assets/73398298/749ef464-6750-4242-8ca2-dc21448d71e4)


## 4.3 Insecure Login 

Die zweite Aufgabe konnte ich durch etwas Zufall lösen. In der Aufgabenbeschreibung stand, dass durch den Klick auf den Login-Button ein Request gesendet wird, in dem sich Credentials eines anderen Users befinden. Da ich diesen Request genauer anschauen wollte, bin ich in den DevTools auf den Netzwerk-Tab gegangen. Der Request war einfach zu finden:

![image](https://github.com/MarcWilhelm/m183_Abschlussarbeit/assets/73398298/8bef7eff-9ad0-4ff2-afc0-968c75a68ecc)

Im Payload stand der Username CaptainJack und das Passwort BlackPearl.
![image](https://github.com/MarcWilhelm/m183_Abschlussarbeit/assets/73398298/bee2b6fd-7c7f-414b-b9d5-35bec20de8d3)

Da diese nicht verschlüsselt waren, konnte ich sie einfach lesen und in das Login-Formular eingeben: 
![image](https://github.com/MarcWilhelm/m183_Abschlussarbeit/assets/73398298/cc30da50-6e9a-4f4c-8eea-f20b43dea074)

Wieder einmal wurde mir klar, wie wichtig Verschlüsselung ist.

## 4.4 Password Reset 

Der Abschnitt Password reset ist in 7 Schritten aufgeteilt. In diesen 7 Schritten gibt es drei Aufgaben, die man lösen muss. In diesem Abschnitt geht es um die Password reset Funktionalität und wie man diese sicher implementiert. 

Die erste Aufgabe ist recht einfach. Es geht darum, sein Passwort zurückzusetzen, indem man eine E-Mail an seinen Account schickt (Passwort vergessen), in der dann das neue Passwort enthalten ist.
![image](https://github.com/MarcWilhelm/m183_Abschlussarbeit/assets/73398298/5b562b31-c57e-4f31-9f38-73b1257313bf)

Ich habe also meine WebGoat E-Mail angegeben und dann auf „Forgot your password“ geklickt.
![image](https://github.com/MarcWilhelm/m183_Abschlussarbeit/assets/73398298/9eb9eb36-77f8-46ad-b916-ee4bb31598a1)

Im Forgot your password-Formular konnte ich eine E-Mail an meinen Account senden, in der sich das neue Passwort befindet.
![image](https://github.com/MarcWilhelm/m183_Abschlussarbeit/assets/73398298/aef53aa8-c613-4147-b0d0-1c180082d5f7)

Ich habe mich bei WebWolf eingeloggt und gesehen, dass ich eine E-Mail erhalten habe, in der das neue Passwort stand. 
![image](https://github.com/MarcWilhelm/m183_Abschlussarbeit/assets/73398298/83d08f30-6946-4a54-9ce3-891bd5860a5b)

Mit dem neuen Passwort konnte ich mich dann anmelden. 

Die zweite Aufgabe habe ich durch Zufall gelöst. Es geht darum, dass man anhand vom Usernamen und einer Sicherheitsfrage das Passwort eines anderen Users herausfindet. In der Aufgabenstellung wird erklärt, dass es die User Tom, Admin und Larry gibt. Die Sicherheitsfrage, die man beantworten muss, ist folgende: „What is your favorite color?“. Ich habe einen eher ineffizienten Lösungsansatz gewählt und einfach den User Admin genommen und dann verschiedene Farben ausprobiert, die mir eingefallen sind. Durch Zufall habe ich nach einigen Versuchen die richtige Farbe herausgefunden.
![image](https://github.com/MarcWilhelm/m183_Abschlussarbeit/assets/73398298/3bff38a9-3615-4b0a-b387-2be3d841512e)


### 4.4.1 Erkenntnisse 

Wenn ein Passwort zurückgesetzt wird, ist es wichtig, dass die Applikation nicht zu viele Informationen preisgibt. Was ist damit gemeint? Gehen wir davon aus, ein Angreifer versucht herauszufinden, ob ein Account mit einer bestimmten E-Mail-Adresse existiert oder nicht. Dazu sendet er über das Passwort-vergessen-Formular einen Request, um das Passwort zurückzusetzen. Wenn die Applikation jetzt die Nachricht „Ein User mit dieser E-Mail existiert nicht“ zurückgibt, weiß der Angreifer, dass es keinen User mit so einer E-Mail gibt. Jetzt hat der Angreifer ein Bild darüber, wie die Applikation reagiert, wenn ein User nicht existiert. Also versucht er es mit einer anderen E-Mail. Beim zweiten Versuch wird erfolgreich eine E-Mail an den User geschickt, um das Passwort zurückzusetzen. Da der Request erfolgreich gesendet wurde, ist dem Angreifer jetzt klar, dass dieser Account existiert. Dadurch könnte er gezielt einen Phishing-Angriff auf den User mit dieser E-Mail-Adresse starten.

Es gibt Webseiten, auf denen es möglich ist, sein Passwort zurückzusetzen, indem man Sicherheitsfragen beantwortet. Bei den Sicherheitsfragen kann der User aus einigen vordefinierten Fragen selbst auswählen, welche er benutzen möchte, um das Passwort zurückzusetzen. Die Antwort für diese Fragen kann er auch selbst festlegen. Da diese Fragen eine mögliche Angriffsfläche bieten, ist es wichtig, dass man mit diesen sicher umgeht. Man sollte diese Fragen mit dem gleichen Level an Sicherheit behandeln wie Passwörter. Ein anderes Problem ist, die richtigen Sicherheitsfragen festzulegen. Bei einer Sicherheitsfrage sollte es für den Angreifer schwierig sein, die Antwort herauszufinden, und für den User sollte es einfach sein, sich die Antwort zu merken.

## 4.5 Secure Passwords 

In diesem Abschnitt geht es darum zu lernen, wie man starke Passwörter erstellt und wie man diese sicher speichert. 

In der Aufgabe ging es darum, ein starkes Passwort zu erstellen und danach verschiedene andere vorgegebene Passwörter auszuprobieren und zu verstehen, warum diese nicht sicher sind. Um ein sicheres Passwort zu erstellen, habe ich nicht viel überlegt und zufällig irgendwelche Tasten auf meiner Tastatur gedrückt. Das von mir erstellte Passwort wurde als sicher gekennzeichnet. 
![image](https://github.com/MarcWilhelm/m183_Abschlussarbeit/assets/73398298/19989985-eb9e-4967-a3c3-5a2bfcc9681c)

Ich habe dann die anderen Passwörter aus der vorgegebenen Liste ausprobiert und ich war erstaunt, dass es bei allen schnell gehen würde, bis diese geknackt wären. Ich habe mir mittlerweile angewöhnt, meine Passwörter immer mit einem Password Manager generieren zu lassen.
![image](https://github.com/MarcWilhelm/m183_Abschlussarbeit/assets/73398298/34043b43-d9b3-4f36-9b37-4f86f0ece6d9)

### 4.5.1 Erkenntnisse 

Es gibt einige Regeln, die man beachten sollte, wenn man ein Passwort erstellt:
- **No composition rules**: Ein User sollte nicht dazu gezwungen werden, bestimmte Regeln zu berücksichtigen beim Erstellen eines Passworts (z.B. verwende mindestens einen Großbuchstaben oder verwende mindestens ein Sonderzeichen etc.)
- **No password hints**
- **No security questions**: Sicherheitsfragen sind unsicher und nicht mehr aktuell.
- **No unnecessary changing of passwords**
- **Minimum size of 8 characters**
- **Support all Unicode characters**
- **Check the password against known bad choices**
```
