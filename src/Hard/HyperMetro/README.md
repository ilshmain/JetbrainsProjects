## Описание

Проект называется Гиперметро.
Мы должны считывать данные с файла и  реализовать связь между линиями метро.
В процессе написания проекта, происходит знакомство с JSON и библиотекой GSON.

### Примечание
При запуске необходимо указать путь к файлу branch.json


## Цель

В программе должны быть следующие команды:
- /append "[line name]" "[station name]"
  - (Например: /append Hammersmith-and-City "Test station")
- /add-head " [line name]" "[station name]"
  - (Например: /add-head  Hammersmith-and-City "Test station")
- /remove "[line name]" "[station name]"
  - (Например: /remove Hammersmith-and-City Hammersmith)
- /connect "[line 1]" "[station 1]" "[line 2]" "[station 2]"
  - (Например: /connect Hammersmith-and-City Hammersmith Metro-Railway "Edgver road")
- /output "[line name]" 
  - (Например: /output "Hammersmith-and-City")
- /exit

Append добавляет новую станцию в конец строки, а add-head добавляет новую станцию в начало.
Обратите внимание, что если название линии или станции состоит из нескольких слов, его следует писать в кавычках 
(после их следует исключить из названия). Если название станции состоит из одного слова, оно должно быть разборчиво 
с кавычками или без них. Output выводит список станций. Connect соединяет станции разных линий метро. 
Exit производит выход из программы.