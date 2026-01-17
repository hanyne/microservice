import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  private gatewayUrl = 'http://localhost:8080/api';

  constructor(private http: HttpClient) { }

  getExploitations(): Observable<any[]> {
    return this.http.get<any[]>(`${this.gatewayUrl}/exploitations`);
  }

  getParcelles(): Observable<any[]> {
    return this.http.get<any[]>(`${this.gatewayUrl}/parcelles`);
  }

  getDonneesCapteur(): Observable<any[]> {
    return this.http.get<any[]>(`${this.gatewayUrl}/donnees-capteur`);
  }

  createExploitation(exploitation: any): Observable<any> {
    return this.http.post<any>(`${this.gatewayUrl}/exploitations`, exploitation);
  }

  createDonneeCapteur(donnee: any): Observable<any> {
    return this.http.post<any>(`${this.gatewayUrl}/donnees-capteur`, donnee);
  }
}