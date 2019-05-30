import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Notebook} from "../models/Notebook";

@Injectable({
  providedIn: 'root'
})
export class NotebookService {

  private BASE_URL = "http:localhost:8082/api/notebooks";
  private GET_ALL_NOTEBOOKS = `${this.BASE_URL}\\all`;
  private GET_NOTEBOOK_ID = this.BASE_URL;
  private SAVE_UPDATE_NOTEBOOK = this.BASE_URL;
  private DELETE_NOTEBOOK = this.BASE_URL;


  constructor(private  http: HttpClient) {}

    getAllNotebooks(): Observable<Notebook[]> {

      return this.http.get<Notebook[]>(this.GET_ALL_NOTEBOOKS);
  }
  postNotebook(notebook: Notebook): Observable<Notebook> {

    return this.http.post<Notebook>(this.SAVE_UPDATE_NOTEBOOK, notebook);
  }
  deleteNotebook(id:string): Observable<any> {

    return this.http.delete(this.DELETE_NOTEBOOK + id);
  }
}
