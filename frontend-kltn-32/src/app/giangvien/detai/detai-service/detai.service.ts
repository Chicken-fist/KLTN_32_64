import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class DetaiService {

  constructor(private httpClient: HttpClient) { }
  postDeTai(data: any){
    return this.httpClient.post<any>("http://localhost:4000/productList", data);
  }
  getDeTai(){
    return this.httpClient.get<any>("http://localhost:4000/productList");
  }
  updateDeTai(data: any, id: any){
    return this.httpClient.put<any>("http://localhost:4000/productList/" + id, data);
  }
  deleteDeTai(id: any){
    return this.httpClient.delete<any>("http://localhost:4000/productList/" + id);
  }
}
