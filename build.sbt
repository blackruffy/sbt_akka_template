lazy val root = (project in file(".")).
  settings(
    name := "akka_template",
    version := "1.0",
    scalaVersion := "2.11.8",

    libraryDependencies ++= {
      val akkaV = "2.3.9"
      val specsV = "3.8.5"
      Seq(
        "com.typesafe.akka"   %%  "akka-actor"      % akkaV,
        "ch.qos.logback"       %  "logback-classic" % "1.1.2",
        "com.typesafe.akka"   %%  "akka-slf4j"      % akkaV,
        "com.typesafe.akka"   %%  "akka-testkit"    % akkaV   % "test",
        "org.specs2"          %%  "specs2-core"     % specsV  % "test",
        "org.specs2"          %%  "specs2-junit"    % specsV  % "test"
      )
    },


    scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8", "-feature"),
    scalacOptions in Test ++= Seq("-Yrangepos"),

    assemblyJarName in assembly := "akka_template.jar",
    mainClass in assembly := Some("net.blackruffy.Main"),

    testOptions in Test += Tests.Argument("junitxml", "console")
  )
