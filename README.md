Scrorings system

cd C:\\Users\\wiell\\Desktop\\AsteroidsGame - Rasmus\\ScoringSystem

mvn spring-boot:run

\-------------------------------------------------------------------

copy Enemy\\target\\Enemy-1.0-SNAPSHOT.jar plugins\\

copy CommonEnemy\\target\\CommonEnemy-1.0-SNAPSHOT.jar plugins\\

copy Player\\target\\Player-1.0-SNAPSHOT.jar plugins\\

copy Bullet\\target\\Bullet-1.0-SNAPSHOT.jar plugins\\

copy CommonBullet\\target\\CommonBullet-1.0-SNAPSHOT.jar plugins\\

copy Asteroids\\target\\Asteroids-1.0-SNAPSHOT.jar plugins\\

copy CommonAsteroids\\target\\CommonAsteroids-1.0-SNAPSHOT.jar plugins\\

\-------------------------------------------------------------------

set MODS=Common/target/Common-1.0-SNAPSHOT.jar;CommonBullet/target/CommonBullet-1.0-SNAPSHOT.jar;Core/target/Core-1.0-SNAPSHOT.jar;Collision/target/Collision-1.0-SNAPSHOT.jar

\-------------------------------------------------------------------

set FX=%USERPROFILE%\\.m2\\repository\\org\\openjfx

set SP=%USERPROFILE%\\.m2\\repository\\org\\springframework

set SPRING=%SP%\\spring-context\\6.0.9\\spring-context-6.0.9.jar;%SP%\\spring-core\\6.0.9\\spring-core-6.0.9.jar;%SP%\\spring-beans\\6.0.9\\spring-beans-6.0.9.jar;%SP%\\spring-aop\\6.0.9\\spring-aop-6.0.9.jar;%SP%\\spring-expression\\6.0.9\\spring-expression-6.0.9.jar;%SP%\\spring-jcl\\6.0.9\\spring-jcl-6.0.9.jar

set JAVAFX=%FX%\\javafx-controls\\17.0.2\\javafx-controls-17.0.2-win.jar;%FX%\\javafx-graphics\\17.0.2\\javafx-graphics-17.0.2-win.jar;%FX%\\javafx-base\\17.0.2\\javafx-base-17.0.2-win.jar

\-------------------------------------------------------------------

java --module-path %MODS%;%SPRING%;%JAVAFX% --module Core/dk.sdu.mmmi.cbse.main.Main





Youtube video link

https://youtu.be/k2L-9PBlq3Q

