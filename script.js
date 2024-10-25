let nome, cpf, saldo;

document.getElementById("iniciar").addEventListener("click", () => {
  nome = document.getElementById("nome").value;
  cpf = document.getElementById("cpf").value;
  saldo = parseFloat(document.getElementById("saldo").value);

  if (!nome || !cpf || isNaN(saldo)) {
    alert("Por favor, preencha todos os campos corretamente!");
    return;
  }

  mostrarMenu();
});

function mostrarMenu() {
  document.getElementById("formulario").classList.add("hidden");
  document.getElementById("menu").classList.remove("hidden");
  atualizarMensagem();
}

function atualizarMensagem() {
  const mensagem = `
  ********************************
  Seus dados:

  Nome:       ${nome}
  CPF:        ${cpf}
  Saldo:      R$${saldo.toFixed(2)}
  ********************************
  `;
  document.getElementById("mensagem").innerText = mensagem;
}

function consultarSaldo() {
  alert(`Seu saldo atual é: R$${saldo.toFixed(2)}`);
}

function receberValor() {
  const valor = parseFloat(prompt("Digite o valor a receber: R$"));
  if (!isNaN(valor) && valor > 0) {
    saldo += valor;
    alert("Valor recebido com sucesso!");
    atualizarMensagem();
  } else {
    alert("Valor inválido!");
  }
}

function transferirValor() {
  const valor = parseFloat(prompt("Digite o valor a transferir: R$"));
  if (!isNaN(valor) && valor > 0) {
    if (valor <= saldo) {
      saldo -= valor;
      alert("Transferência realizada com sucesso!");
      atualizarMensagem();
    } else {
      alert("Saldo insuficiente!");
    }
  } else {
    alert("Valor inválido!");
  }
}

function sair() {
  alert("Saindo... Obrigado por usar o sistema!");
  location.reload(); // Reinicia a página
}
