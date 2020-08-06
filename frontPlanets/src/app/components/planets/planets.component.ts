import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../environments/environment';
import { PlanetService } from '../../services/planet.services';


export interface planet {
  id: string;
  name: string;
  rotationPeriod: string;
  diameter: Date;
  climate: string;
  field: string;
  cantidad: BigInteger;
  inhabitants: BigInteger;
}

@Component({
  selector: 'app-planet',
  templateUrl: './planets.component.html',
  styleUrls: ['./planets.component.css']
})
export class PlanetsComponent implements OnInit {
  navbar = {
    items: [environment.CREAR_CAR, environment.MIS_CAR, environment.CONSULTAR_CAR],
    currentView: environment.MIS_CAR
  };
  _http: HttpClient;
  planets: planet[] = [];
  constructor(private planetService: PlanetService, private router: Router) { }

  ngOnInit(): void {
    this.getMisCar();
  }

  public getMisCar() {
    this.planetService.getAllPlanets().subscribe(data => {

      data.forEach((element) => {
        console.log(element);
        const per = {
          id: element.id,
          name: element.name,
          rotationPeriod: element.rotationPeriod,
          diameter: element.diameter,
          climate: element.climate,
          field: element.field,
          inhabitants: element.inhabitants,
          cantidad: element.cantidad
        };

        this.planets.push(per);

      });
    }, err => null);
  }
  public redireccion(id: bigint) {
    this.router.navigate(['/planets/' + id ]);

  }
}