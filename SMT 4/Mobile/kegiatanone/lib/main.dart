// ignore_for_file: prefer_const_constructors, duplicate_ignore, avoid_print

import 'package:flutter/material.dart';
import 'package:kegiatantwo/pageone.dart';
import 'package:kegiatantwo/preferences.dart';
import 'loginpage.dart';
import 'package:shared_preferences/shared_preferences.dart';

Future<void> main() async {
  WidgetsFlutterBinding.ensureInitialized();
  SharedPreferences prefs = await SharedPreferences.getInstance();
  darkmode = prefs.getBool('darkmode') ?? true;
  loggedIn = prefs.getBool('loggedIn') ?? false;
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
  print('AM I LOGGED IN?: ' + loggedIn.toString());
  runApp(MaterialApp(home: loggedIn == false ? Login() : PageOne()));
}
