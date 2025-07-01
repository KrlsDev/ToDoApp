import 'package:flutter/material.dart';
import 'package:todo_app/carpetas_personales/karlos/presentation/pantalla_carlos.dart';
import 'package:todo_app/config/theme/app_theme.dart';
import 'package:todo_app/screen/home_page.dart';


void main() => runApp(const MyApp());

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Material App',
      theme: AppTheme().getTheme(),
      routes: {
        '/pantallakarlos': (context) => PantallaCarlos()
      },
      home: HomePage(),
    );
  }
}




