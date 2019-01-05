This directory includes a binary distribution of WinRun4J,
which is used to execute protoc plugins written in Java
under 32-bit and 64-bit Windows operating systems.

The version of the binaries is 0.4.4, and the original download link is:
https://sourceforge.net/projects/winrun4j/files/winrun4j/0.4.4/

The files from the original distribution archive were renamed as follows:

Inside winrun4J-0.4.4.zip   | In this directory | File size
----------------------------+-------------------+----------
winrun4j\bin\WinRun4J.exe   | WinRun4J32.exe    |    46,592
winrun4j\bin\WinRun4J64.exe | WinRun4J64.exe    |   162,816

MD5 and SHA256 hashes can be verified as follows:

$ md5sum    -c WinRun4J.md5
$ sha256sum -c WinRun4J.sha

Signature can be verified with GPG:

$ gpg --receive-keys 57F0A563FBCA5E5C59E6CA83063F2A19A91D9031
$ gpg --verify WinRun4J.sha.asc WinRun4J.sha

...or with Keybase:

$ keybase id sergei_ivanov
$ keybase pgp verify -i WinRun4J.sha -d WinRun4J.sha.asc

Additional information about WinRun4J is available on
the project's home page:
http://winrun4j.sourceforge.net/
