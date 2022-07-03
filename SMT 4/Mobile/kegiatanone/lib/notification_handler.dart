import 'dart:io';
import 'package:firebase_messaging/firebase_messaging.dart';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:flutter_local_notifications/flutter_local_notifications.dart';
import 'auth.dart';
import 'package:firebase_auth/firebase_auth.dart';

// Pages
import 'main.dart';
import 'pageone.dart';
import 'pagetwo.dart';
import 'pagethree.dart';
import 'pagefour.dart';
import 'pagefive.dart';
import 'accountpage.dart';
import 'loginpage.dart';

final FlutterLocalNotificationsPlugin flutterLocalNotificationsPlugin =
    FlutterLocalNotificationsPlugin();

initializaNotification() async {
  final fcm = FirebaseMessaging.instance;
  debugPrint("The Token: ${(await FirebaseMessaging.instance.getToken())}");

  try {
    if (Platform.isIOS) {
      await fcm.requestPermission(alert: true, badge: true, sound: true);
      await fcm.setForegroundNotificationPresentationOptions(
          alert: true, badge: true, sound: true);
      FirebaseMessaging.onMessage.listen((event) {});
      FirebaseMessaging.onBackgroundMessage((message) async {});
      FirebaseMessaging.onMessageOpenedApp.listen((event) {});
    }
  } catch (e) {
    debugPrint(e.toString());
  }

  FirebaseMessaging.onMessage.listen(_onMessage);
  FirebaseMessaging.onBackgroundMessage(_onBackgroundMessage);
  FirebaseMessaging.onMessageOpenedApp.listen(_onOpened);
  // FirebaseMessaging.instance.setForegroundNotificationPresentationOptions(
  //   alert: true,
  //   badge: true,
  //   sound: true,
  // );

  final message = await fcm.getInitialMessage();
  if (message != null) {
    int id =
        int.parse(message.data.toString().replaceAll(RegExp(r'[^0-9]'), ''));
    debugPrint("ONENTRY: $id");
    try {
      switch (id) {
        case 0: //TO RELOG
          AuthenticationService service =
              AuthenticationService(FirebaseAuth.instance);
          service.signOut();
          Navigator.of(globalContext).push(MaterialPageRoute(
              builder: (_) => const Login(), maintainState: false));
          break;
        case 1: //TO PAGE ONE
          Navigator.of(globalContext).push(MaterialPageRoute(
              builder: (_) => const PageOne(), maintainState: false));
          break;
        case 2: //TO PAGE TWO
          Navigator.of(globalContext).push(MaterialPageRoute(
              builder: (_) => const PageTwo(), maintainState: false));
          break;
        case 3: //TO PAGE THREE
          Navigator.of(globalContext).push(MaterialPageRoute(
              builder: (_) => const PageThree(), maintainState: false));
          break;
        case 4: //TO PAGE FOUR
          Navigator.of(globalContext).push(MaterialPageRoute(
              builder: (_) => const PageFour(), maintainState: false));
          break;
        case 5: //TO PAGE FIVE
          Navigator.of(globalContext).push(MaterialPageRoute(
              builder: (_) => const PageFive(), maintainState: false));
          break;
        case 6: //TO ACCOUNT PAGE
          Navigator.of(globalContext).push(MaterialPageRoute(
              builder: (_) => const AccountPage(), maintainState: false));
          break;
        default:
      }
    } catch (e) {
      debugPrint("EXCEPTION THROWN!");
      Login();
    }
  }
}

void _onMessage(RemoteMessage message) {
  debugPrint("ONMSG: ${message.notification?.title}");
  debugPrint("${message.notification?.body}");
  RemoteNotification? notification = message.notification;
  AndroidNotification? android = message.notification?.android;
  if (notification != null && android != null) {
    flutterLocalNotificationsPlugin.show(
      notification.hashCode,
      notification.title,
      notification.body,
      NotificationDetails(
        android: AndroidNotificationDetails(
          channel.id,
          channel.name,
          color: Colors.blue,
          playSound: true,
          icon: '@mipmap/ic_launcher',
        ),
      ),
    );
  }
}

Future<void> _onBackgroundMessage(RemoteMessage message) async {
  debugPrint("ONBG: ${message.notification?.title}");
  debugPrint("${message.notification?.body}");
}

void _onOpened(RemoteMessage message) {
  int id = int.parse(message.data.toString().replaceAll(RegExp(r'[^0-9]'), ''));
  debugPrint("ONENTRY: $id");
  try {
    switch (id) {
      case 0: //TO RELOG
        AuthenticationService service =
            AuthenticationService(FirebaseAuth.instance);
        service.signOut();
        Navigator.of(globalContext).push(MaterialPageRoute(
            builder: (_) => const Login(), maintainState: false));
        break;
      case 1: //TO PAGE ONE
        Navigator.of(globalContext).push(MaterialPageRoute(
            builder: (_) => const PageOne(), maintainState: false));
        break;
      case 2: //TO PAGE TWO
        Navigator.of(globalContext).push(MaterialPageRoute(
            builder: (_) => const PageTwo(), maintainState: false));
        break;
      case 3: //TO PAGE THREE
        Navigator.of(globalContext).push(MaterialPageRoute(
            builder: (_) => const PageThree(), maintainState: false));
        break;
      case 4: //TO PAGE FOUR
        Navigator.of(globalContext).push(MaterialPageRoute(
            builder: (_) => const PageFour(), maintainState: false));
        break;
      case 5: //TO PAGE FIVE
        Navigator.of(globalContext).push(MaterialPageRoute(
            builder: (_) => const PageFive(), maintainState: false));
        break;
      case 6: //TO ACCOUNT PAGE
        Navigator.of(globalContext).push(MaterialPageRoute(
            builder: (_) => const AccountPage(), maintainState: false));
        break;
      default:
    }
  } catch (e) {
    debugPrint("EXCEPTION THROWN!");
    Login();
  }
}

const AndroidNotificationChannel channel = AndroidNotificationChannel(
  'my_channel', // id
  'My Channel', // title
  importance: Importance.high,
);
