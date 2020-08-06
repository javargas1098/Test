import { Component, Input, OnInit, ViewEncapsulation } from '@angular/core';
import { environment } from '../../../../environments/environment';


@Component({
  selector: 'app-navbar',
  encapsulation: ViewEncapsulation.Emulated,
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  @Input()
  navbar = { items: [], currentView: null };

  ngOnInit(): void {

  }
  /**
   * Getter para poder utilizar las variables globales en el archivo .html.
   *
   * @return {string}
   */
  get CREAR_CAR() {
    return environment.CREAR_CAR;
  }

  /**
   * Getter para poder utilizar las variables globales en el archivo .html.
   *
   * @return {string}
   */
  get MIS_CAR() {
    return environment.MIS_CAR;
  }

  /**
   * Getter para poder utilizar las variables globales en el archivo .html.
   *
   * @return {string}
   */
  get CONSULTAR_CAR() {
    return environment.CONSULTAR_CAR;
  }
}


