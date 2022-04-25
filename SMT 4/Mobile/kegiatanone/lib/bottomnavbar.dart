// ignore_for_file: prefer_const_constructors
import 'package:flutter/material.dart';
import 'package:kegiatantwo/preferences.dart';
import 'package:kegiatantwo/pageone.dart';
import 'package:kegiatantwo/pagetwo.dart';
import 'package:kegiatantwo/pagethree.dart';
import 'package:kegiatantwo/pagefour.dart';
import 'package:kegiatantwo/pagefive.dart';

class BottomNavBar extends StatefulWidget {
  const BottomNavBar({Key? key}) : super(key: key);

  @override
  State<BottomNavBar> createState() => _BottomNavBarState();
}

class _BottomNavBarState extends State<BottomNavBar> {
  @override
  Widget build(BuildContext context) {
    return BottomNavigationBar(
      onTap: (index) {
        switch (index) {
          case 0:
            Navigator.of(context).pushAndRemoveUntil(
                MaterialPageRoute(builder: (context) => PageOne()),
                (Route<dynamic> route) => false);
            break;
          case 1:
            Navigator.of(context).pushAndRemoveUntil(
                MaterialPageRoute(builder: (context) => PageTwo()),
                (Route<dynamic> route) => false);
            break;
          case 2:
            Navigator.of(context).pushAndRemoveUntil(
                MaterialPageRoute(builder: (context) => PageThree()),
                (Route<dynamic> route) => false);
            break;
          case 3:
            Navigator.of(context).pushAndRemoveUntil(
                MaterialPageRoute(builder: (context) => PageFour()),
                (Route<dynamic> route) => false);
            break;
          case 4:
            Navigator.of(context).pushAndRemoveUntil(
                MaterialPageRoute(builder: (context) => PageFive()),
                (Route<dynamic> route) => false);
            break;
        }
      },
      type: BottomNavigationBarType.fixed,
      backgroundColor: hitam,
      unselectedItemColor: abuabu,
      selectedItemColor: abuabu,
      items: const [
        BottomNavigationBarItem(icon: Icon(Icons.home), label: 'Home'),
        BottomNavigationBarItem(icon: Icon(Icons.explore), label: 'Explore'),
        BottomNavigationBarItem(icon: Icon(Icons.sensors), label: 'Live'),
        BottomNavigationBarItem(
            icon: Icon(Icons.access_time), label: 'History'),
        BottomNavigationBarItem(
            icon: Icon(Icons.add_circle_outline), label: 'Add'),
      ],
    );
  }
}
