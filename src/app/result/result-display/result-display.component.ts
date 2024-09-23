import { CommonModule } from '@angular/common';
import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-result-display',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './result-display.component.html',
  styleUrl: './result-display.component.css'
})
export class ResultDisplayComponent {
  @Input() resultadoBeneficioReal: number | null = null;
  @Input() resultadoPoderPublico: number | null = null; // Recibir el valor desde el padre
  @Input() rescateMayorPago: boolean = false;  // Recibe el booleano
  @Input() iFichasPremiadas: number | null = null;
  @Input() iFichasAPagar: number | null = null;
  @Input() eFichasPremiadas: number | null = null;
  @Input() eFichasAPagar: number | null = null;

}
