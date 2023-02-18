import {Component, OnInit, ViewChild} from '@angular/core';
import {MatDialog, MAT_DIALOG_DATA} from '@angular/material/dialog';
import {ThemDeTaiGvComponent} from "../../../dialog/them-de-tai-gv/them-de-tai-gv.component";
import {DetaiService} from "../detai-service/detai.service";
import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material/sort';
import {MatTableDataSource} from '@angular/material/table';

@Component({
  selector: 'app-detai',
  templateUrl: './detai.component.html',
  styleUrls: ['./detai.component.css']
})
export class DetaiComponent implements OnInit {
  constructor(public dialog: MatDialog, private detaiService: DetaiService) {
  }

  ngOnInit(): void {
    this.getAllProduct();
  }

  private getAllProduct() {
    this.detaiService.getDeTai()
      .subscribe({
        next: (res) => {
          this.dataSource = new MatTableDataSource(res);
          this.dataSource.paginator = this.paginator;
          this.dataSource.sort = this.sort;
        },
        error: () => {
          console.log("Error")
        }
      })
  }

  openDialog() {
    this.dialog.open(ThemDeTaiGvComponent, {}).afterClosed().subscribe(val => {
      if (val === "save") {
        this.getAllProduct()
      }
    })
  }

  editProduct(row: any) {
    this.dialog.open(ThemDeTaiGvComponent, {
      data: row
    }).afterClosed().subscribe(val => {
      if (val === "update") {
        this.getAllProduct()
      }
    })
  }

  // Table
  displayedColumns: string[] = ['productName', 'category', 'seasons', "price", "comment", "date", "action"];
  dataSource!: MatTableDataSource<any>;

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }

  deleteProduct(id: any) {
  this.detaiService.deleteDeTai(id).subscribe({
    next: (res) => {
      this.getAllProduct();
    },
    error: () => {
      console.log("Error")
    }
  })
  }
}
