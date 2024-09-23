import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { HeaderComponent } from "./header/header/header.component";
import { FootComponent } from "./foot/foot/foot.component";
import { InputFormComponent } from "./form/input-form/input-form.component";
import { ResultDisplayComponent } from "./result/result-display/result-display.component";
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, HeaderComponent, FootComponent, InputFormComponent, ResultDisplayComponent,CommonModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'CajaDeConversion';

  resultadoBeneficioReal: number | null = null;
  resultadoPoderPublico: number | null = null;
  rescateMayorPago: boolean = false;  // booleano
  resultados: any = {};
  resultadosDisponibles: boolean = false; // booleano muestra o no los resultados

  onResultadoCalculado(resultados: { beneficioReal: number, poderPublico: number, rescateMayorPago: boolean }) {
    
    // Actualizamos ambos resultados
    this.resultadoBeneficioReal = resultados.beneficioReal;
    this.resultadoPoderPublico = resultados.poderPublico;
    this.rescateMayorPago = resultados.rescateMayorPago;
    this.resultados = resultados;
    this.resultadosDisponibles = true; // booleano muestra o no los resultados
  }
}
