import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../environments/environment';
import { PersonService } from '../../services/person.service';


export interface person {
  card: string;
  type: string;
  name: string;
  gender: Date;
  age: string;
  weight: string;
  dateBirth: string;
  cantidad: BigInteger;
}

@Component({
  selector: 'app-persons',
  encapsulation: ViewEncapsulation.Emulated,
  templateUrl: './persons.component.html',
  styleUrls: ['./persons.component.css']
})
export class PersonsComponent implements OnInit {

  navbar = {
    items: [environment.CREAR_CAR, environment.MIS_CAR, environment.CONSULTAR_CAR],
    currentView: environment.MIS_CAR
  };
  _http: HttpClient;
  persons: person[] = [];
  constructor(private personService: PersonService, private router: Router) { }

  ngOnInit(): void {
    this.getMisCar();
  }

  public getMisCar() {
    this.personService.getAllPersons().subscribe(data => {

      data.forEach((element) => {
        console.log(element);
        const per = {
          card: element.personId.card,
          type: element.personId.type,
          name: element.name,
          gender: element.gender,
          age: element.age,
          weight: element.weight,
          dateBirth: element.dateBirth,
          cantidad: element.cantidad
        };

        this.persons.push(per);

      });
    }, err => null);
  }
  public redireccion(id: bigint, type: string) {
    this.router.navigate(['/persons/' + id + "/"+ type]);

  }
}
