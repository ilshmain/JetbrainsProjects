## Описание

Проект называется Гиперметро.
Мы должны считывать данные с файла и  реализовать связь между линиями метро.
В процессе написания проекта, происходит знакомство с JSON и библиотекой GSON.

### Примечание
При запуске необходимо указать путь к файлу branch.json


## Цель

В программе реализованы следующие команды:
- /append "[line name]" "[station name]"
  - (Описание: append добавляет новую станцию в конец строки)
  - (Например: /append Hammersmith-and-City "Test station")
- /add-head " [line name]" "[station name]"
  - (Описание: add-head добавляет новую станцию в начало)
  - (Например: /add-head  Hammersmith-and-City "Test station")
- /remove "[line name]" "[station name]"
  - (Описание: remove удаляет станцию)
  - (Например: /remove Hammersmith-and-City Hammersmith)
- /connect "[line 1]" "[station 1]" "[line 2]" "[station 2]"
  - (Описание: connect создает связь между станциями разных линий метро)
  - (Например: /connect Hammersmith-and-City Hammersmith Metro-Railway "Edgver road")
- /output "[line name]" 
  - (Описание: output выводит станции метро)
  - (Например: /output "Hammersmith-and-City")
- /exit
