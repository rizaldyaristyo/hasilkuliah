## Nuclei

`nuclei -u http://10.10.11.239/ -s critical,high,medium,low`

[laravel-env] [http] [high] [](http://10.10.11.239/.env)[http://10.10.11.239/.env](http://10.10.11.239/.env)

[composer-auth-json] [http] [low] [](http://10.10.11.239/vendor/webmozart/assert/.composer-auth.json)[http://10.10.11.239/vendor/webmozart/assert/.composer-auth.json](http://10.10.11.239/vendor/webmozart/assert/.composer-auth.json)

## FFuF

`ffuf -w ./onelistforallmicro.txt -u http://10.10.11.239/FUZZ -mc 200,300,301,302 -v -c`

[](http://10.10.11.239/vendor/autoload.php)[http://10.10.11.239/vendor/autoload.php](http://10.10.11.239/vendor/autoload.php)

[](http://10.10.11.239/.gitattributes)[http://10.10.11.239/.gitattributes](http://10.10.11.239/.gitattributes)

[](http://10.10.11.239/server.php)[http://10.10.11.239/server.php](http://10.10.11.239/server.php)

[](http://10.10.11.239/storage/logs/laravel.log)[http://10.10.11.239/storage/logs/laravel.log](http://10.10.11.239/storage/logs/laravel.log)

[](http://10.10.11.239/.env)[http://10.10.11.239/.env](http://10.10.11.239/.env)

## HTTPX

`echo 10.10.11.239 | httpx -path fuzz.txt -mc 200`

ENV File [](http://10.10.11.239/.env)[http://10.10.11.239/.env](http://10.10.11.239/.env)

Gitignore [](http://10.10.11.239/.gitignore)[http://10.10.11.239/.gitignore](http://10.10.11.239/.gitignore)

Error Log [](http://10.10.11.239/storage/logs/laravel.log)[http://10.10.11.239/storage/logs/laravel.log](http://10.10.11.239/storage/logs/laravel.log)

Iterable Folder [](http://10.10.11.239/app/)[http://10.10.11.239/app/](http://10.10.11.239/app/)

Iterable Folder [](http://10.10.11.239/config/)[http://10.10.11.239/config/](http://10.10.11.239/config/)

Iterable Folder [](http://10.10.11.239/database/)[http://10.10.11.239/database/](http://10.10.11.239/database/)

Iterable Folder [](http://10.10.11.239/public/)[http://10.10.11.239/public/](http://10.10.11.239/public/)

Iterable Folder [](http://10.10.11.239/resources/)[http://10.10.11.239/resources/](http://10.10.11.239/resources/)

Iterable Folder [](http://10.10.11.239/storage/)[http://10.10.11.239/storage/](http://10.10.11.239/storage/)

Iterable Folder [](http://10.10.11.239/tests/)[http://10.10.11.239/tests/](http://10.10.11.239/tests/)

Iterable Folder [](http://10.10.11.239/vendor/)[http://10.10.11.239/vendor/](http://10.10.11.239/vendor/)

## Dirb

`dirb http://10.10.11.239`

[http://10.10.11.239/app/](http://10.10.11.239/app/)

[http://10.10.11.239/config/](http://10.10.11.239/config/)

[http://10.10.11.239/database/](http://10.10.11.239/database/)

[http://10.10.11.239/javascript/](http://10.10.11.239/javascript/)

[http://10.10.11.239/public/](http://10.10.11.239/public/)

[http://10.10.11.239/resources/](http://10.10.11.239/resources/)

[http://10.10.11.239/routes](http://10.10.11.239/routes)

[http://10.10.11.239/screenshot/](http://10.10.11.239/screenshot/)

[http://10.10.11.239/storage/](http://10.10.11.239/storage/)

[http://10.10.11.239/tests/](http://10.10.11.239/tests/)

[http://10.10.11.239/vendor/](http://10.10.11.239/vendor/)

# Mitigasi

### Directory Listing

Tambahkan `Options -Indexes` dalam file `/etc/httpd/conf` atau `/etc/apache2/sites-available` di direktif `<Directory /var/www/html>`.

### Sensitive Documents Disclosure (.env, .gitignore, laravel.log)

Tambahkan setting berikut pada direktif VirtualHost pada setting vhost apache untuk mencegah adanya eksposur dokumen rahasia di webserver.

```jsx
<FilesMatch "(\\.env|\\.gitignore|laravel\\.log|db\\.conf)">
	Order allow,deny
	Deny from all
</FilesMatch>

```
