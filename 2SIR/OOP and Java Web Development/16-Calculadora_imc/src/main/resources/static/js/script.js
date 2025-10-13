function validar() {
	const auxAltura = document.getElementById('altura');

	const auxException = document.getElementById('exception');

	auxException.textContent = '';

	const valor = (auxAltura.value || '').trim().replace(',', '.');

	const altura = Number(valor);

	if (!Number.isFinite(altura)) {
		auxException.textContent = 'Altura inválida!';

		auxAltura.focus();

		return false;
	}

	if (altura < 0.5 || altura > 2.51) {
		auxException.textContent = 'Altura inválida!';

		auxAltura.focus();

		return true;
	}
}
