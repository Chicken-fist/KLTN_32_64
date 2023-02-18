import {Component, Inject, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {DetaiService} from "../../giangvien/detai/detai-service/detai.service";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";

@Component({
  selector: 'app-them-de-tai-gv',
  templateUrl: './them-de-tai-gv.component.html',
  styleUrls: ['./them-de-tai-gv.component.css']
})
export class ThemDeTaiGvComponent implements OnInit {
  actionBtn : string = "Save"
  constructor(private formBuilder: FormBuilder,
              private detaiService: DetaiService,
              private dialogRef: MatDialogRef<ThemDeTaiGvComponent>,
              @Inject(MAT_DIALOG_DATA) public editData: any) {
  }

  ngOnInit(): void {
    this.productForm = this.formBuilder.group({
      productName: ['', Validators.required],
      category: ['', Validators.required],
      seasons: ['', Validators.required],
      price: ['', Validators.required],
      comment: ['', Validators.required],
      date: ['', Validators.required]
    })
    console.log(this.editData)
    if (this.editData) {
      this.productForm.controls['productName'].setValue(this.editData.productName);
      this.productForm.controls['category'].setValue(this.editData.category);
      this.productForm.controls['seasons'].setValue(this.editData.seasons);
      this.productForm.controls['price'].setValue(this.editData.price);
      this.productForm.controls['comment'].setValue(this.editData.comment);
      this.productForm.controls['date'].setValue(this.editData.date);
      this.actionBtn = "Update"
    }
  }

  seasons: string[] = ['Winter', 'Spring', 'Summer', 'Autumn'];
  productForm!: FormGroup;

  addProduct() {
    if(this.editData == null){
      if (this.productForm.valid) {
        this.detaiService.postDeTai(this.productForm.value)
          .subscribe({
            next: (res) => {
              this.productForm.reset();
              this.dialogRef.close('save');
            },
            error: () => {
              alert("XXX")
            }
          })
      }
    }
    else{
        this.detaiService.updateDeTai(this.productForm.value, this.editData.id)
          .subscribe({
            next: (res) => {
              this.productForm.reset();
              this.dialogRef.close('update');
            },
            error: () => {
              alert("XXX")
            }
          })
      this.editData = null;
      }
    }
}
