Создано простое консольное приложение, нужно сделать контейнер для запуска posgres

Создайте Docker контейнер для PostgreSQL
```
docker run --name my-postgres -e POSTGRES_PASSWORD=mysecretpassword -d -p 5432:5432 postgres
```

Объяснение параметров:
* --name my-postgres: Дает контейнеру имя my-postgres.
* -e POSTGRES_PASSWORD=mysecretpassword: Устанавливает пароль для пользователя postgres. Вы можете заменить mysecretpassword на другой пароль.
* -d: Запускает контейнер в фоновом режиме (detached mode).
* -p 5432:5432: Привязывает порт контейнера 5432 к порту 5432 на хосте (это стандартный порт PostgreSQL).
postgres: Имя образа, который мы хотим использовать. Если образ не найден на вашем компьютере, Docker автоматически загрузит его из Docker Hub.

Шаг 3: Подключение к PostgreSQL

После того, как контейнер запущен, вы можете подключиться к базе данных PostgreSQL с помощью любого клиента, поддерживающего PostgreSQL, например, psql или любой GUI-инструмент, такой как pgAdmin.

Пример команды для подключения через psql (если он установлен):
```
psql -h localhost -U postgres
```
Шаг 5: Остановка и удаление контейнера
Чтобы остановить контейнер, используйте:

```
docker stop my-postgres
```

Чтобы удалить контейнер:

```bash
docker rm my-postgres
```

Дополнительные аргументы
Если вы хотите указать имя базы данных, а также пользователя и пароль, вы можете расширить команду:

```bash
docker run --name my-postgres -e POSTGRES_DB=my_database -e POSTGRES_USER=my_user -e POSTGRES_PASSWORD=mysecretpassword -d -p 5432:5432 postgres
```

Пример Docker Compose

Если вы хотите использовать Docker Compose для настройки среды с PostgreSQL, создайте файл docker-compose.yml в вашем проекте:

```yaml
version: '3.8'

services:
  postgres:
    image: postgres
    restart: always
    environment:
      POSTGRES_DB: my_database
      POSTGRES_USER: my_user
      POSTGRES_PASSWORD: mysecretpassword
    ports:
      - "5432:5432"
```
Запустите контейнер с помощью команды:

```
docker-compose up -d
```
Теперь у вас есть контейнер PostgreSQL, который можно использовать для вашего проекта. Если возникнут дополнительные вопросы, дайте знать!