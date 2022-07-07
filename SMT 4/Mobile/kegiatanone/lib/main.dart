// ignore_for_file: prefer_const_constructors, duplicate_ignore, avoid_print

import 'dart:io';
import 'package:firebase_auth/firebase_auth.dart';
import 'package:firebase_core/firebase_core.dart';
import 'package:flutter/material.dart';
import 'package:kegiatantwo/pageone.dart';
import 'package:kegiatantwo/preferences.dart';
import 'package:kegiatantwo/videos/services/videoservice.dart';
import 'package:provider/provider.dart';
import 'loginpage.dart';
import 'package:shared_preferences/shared_preferences.dart';
import 'firebase_options.dart';
import 'package:kegiatantwo/auth.dart';
import 'package:kegiatantwo/notification_handler.dart';

Future<void> main() async {
  HttpOverrides.global = MyHttpOverrides();
  WidgetsFlutterBinding.ensureInitialized();
  await Firebase.initializeApp(options: DefaultFirebaseOptions.currentPlatform);
  await initializaNotification();
  SharedPreferences prefs = await SharedPreferences.getInstance();
  AuthenticationService service = AuthenticationService(FirebaseAuth.instance);
  darkmode = prefs.getBool('darkmode') ?? true;
  // loggedIn = prefs.getBool('loggedIn') ?? false;
  service.getUserData();
  usernamenya = prefs.getString('usernamenya') ?? '';
  if (darkmode == true) {
    abuabu900 = Colors.grey[900];
    abuabu700 = Colors.grey[700];
    abuabu = Colors.grey;
    putih = Colors.white;
    hitam = Colors.white10;
  } else {
    abuabu900 = Colors.white;
    abuabu700 = Colors.red;
    abuabu = Colors.black;
    putih = Colors.black;
    hitam = Colors.white60;
  }
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MultiProvider(
      providers: [
        ChangeNotifierProvider<VideoService>(
          create: (context) => VideoService(),
        )
      ],
      child: MaterialApp(
          debugShowCheckedModeBanner: false,
          home: service.getUserData() == 'null' ? Login() : PageOne()),
    );
  }
}

class MyHttpOverrides extends HttpOverrides{
  @override
  HttpClient createHttpClient(SecurityContext? context){
    return super.createHttpClient(context)
      ..badCertificateCallback = (X509Certificate cert, String host, int port)=> true;
  }
}