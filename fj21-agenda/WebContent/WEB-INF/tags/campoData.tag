<%@ attribute name="id" required="true" %>

<input id="${id}" name="${id}" />
<script>
  $("#${id}").datepicker({dateFormat: 'dd/mm/yy', changeMonth: true,
     					  changeYear: true//, minDate: -20, maxDate: "+1M +10D"
     					  });
</script>